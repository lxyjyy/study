/**
 * Created by liuso on 2017/4/11.
 */

// 当前页
var currentPage = 1;
// 数量
var currentSize = 10;

/**
 * 页面初始化
 */
var updateFlag,deleteFlag;
$(function () {
	
	// 更新权限
	updateFlag = ('true' == $("#updateFlag").val());
    // 删除权限
    deleteFlag = ('true' == $("#deleteFlag").val());

    // 加载数据
    loadData(currentPage, currentSize);

    // 绑定搜索事件
    $('#queryBut').click(function(){
    	loadData(1, currentSize);
    });
    
    // 绑定导出事件
    $('#exportBut').click(function () {
    	window.location.href = $('#baseUrl').attr('href') + 'material/export';
    });
    
    // 绑定重新推荐事件
    $('#recommendBut').click(function () {
    	$.LoadingOverlay("show",{custom  : getCustomElement('正在为物料重新推荐货位类型，请耐心等待...')});
    	$.get($('#baseUrl').attr('href') + "material/recommend",function(data){
    		 $.LoadingOverlay("hide");
    		if(data){
    			if(data.success){
        			alert('重新推荐成功');
        			// 重新加载数据
                    loadData(1, currentSize);
        		}else{
        			alert(data.msg);
        		}
    		}else{
    			alert('重新推荐失败');
    		}
    	});
    });
    
    // 添加模态框
    var $addMaterialModal = $('#addMaterialModal');

    // 绑定添加仓库表单提交
    $addMaterialModal.find('.btn-primary').on('click', function () {
    	$addMaterialModal.find('form').submit();
    });
    
    // 切换货位类型获取对应货位
    $(document).find("[name=cargoLocationTypeId]").on('change',function(){
    	var location = $(this).parent().parent().parent().find('[name=cargoLocationId]');
    	loadLocatioin(location,$(this).val(),'');
    });
    
    var fileds = {
    		maxStore: {
            	validators: {
                    notEmpty: {
                        message: '最大存放不能为空'
                    },
                    integer: {
                        thousandsSeparator: '',
                        decimalSeparator: '',
                        message: '最大存放必须为正整数'
                    },
                    callback:{
                    	message : '最大存放必须大于零',
                    	callback : function (value, validator, $field){
                    		if(!value){
                    			return true;
                    		}
                    		if(!FormValidation.Validator.integer.validate(validator,$field,null)){
                    			return true;
                    		}
                    		if(parseInt(value) > 0){
                    			return true;
                    		}
                    		return false;
                    	}
                    }
                }
            },
            length: {
                validators: {
                    notEmpty: {
                        message: '长不能为空'
                    },
                    numeric: {
                        message: '长必须为数字'
                    },
                    callback:{
                    	message : '长必须大于零',
                    	callback : function (value, validator, $field){
                    		if(!value){
                    			return true;
                    		}
                    		if(!$.isNumeric(value)){
                    			return true;
                    		}
                    		if(parseFloat(value) > 0){
                    			return true;
                    		}
                    		return false;
                    	}
                    }
                }
            },
            width: {
                validators: {
                    notEmpty: {
                        message: '宽不能为空'
                    },
                    numeric: {
                        message: '宽必须为数字'
                    },
                    callback:{
                    	message : '宽必须大于零',
                    	callback : function (value, validator, $field){
                    		if(!value){
                    			return true;
                    		}
                    		if(!$.isNumeric(value)){
                    			return true;
                    		}
                    		if(parseFloat(value) > 0){
                    			return true;
                    		}
                    		return false;
                    	}
                    }
                }
            },
            height: {
                validators: {
                    notEmpty: {
                        message: '高不能为空'
                    },
                    numeric: {
                        message: '高必须为数字'
                    },
                    callback:{
                    	message : '高必须大于零',
                    	callback : function (value, validator, $field){
                    		if(!value){
                    			return true;
                    		}
                    		if(!$.isNumeric(value)){
                    			return true;
                    		}
                    		if(parseFloat(value) > 0){
                    			return true;
                    		}
                    		return false;
                    	}
                    }
                }
            }
        };

    // 绑定添加表单检验事件
    $addMaterialModal.find('form').formValidation({
        framework: 'bootstrap',
        excluded: ':disabled',
        icon: {
            valid: 'fa fa-check',
            invalid: 'fa fa-times',
            validating: 'fa fa-refresh'
        },
        fields: $.extend(fileds,
        	{
	        	code: {
		            validators: {
		                notEmpty: {
		                    message: '物料编码不能为空'
		                }
		            }
	        	},
	        	remote: {
                	url: $('#baseUrl').attr('href') + "material/findCodeIsExist",
                	data : {id : 0},
                    type: 'GET',
                    delay: 1000,
                    message:'物料编码已经存在'
                }
        	}
        )
    }).on('success.form.fv', function (e) {
        // Prevent form submission
        e.preventDefault();

        var $form = $(e.target),
            fv = $form.data('formValidation'),
            $modal = $form.parent().parent().parent().parent();
        
        $.LoadingOverlay("show");
        $.ajax({
            url: $form.attr('action'),
            type: 'PUT',
            data: $form.serialize(),
            success: function (result) {
            	$.LoadingOverlay("hide");
                if (result) {
                    console.log('添加成功');
                    // 隐藏模态框
                    $modal.modal('hide');
                    // 重新加载数据
                    loadData(1, currentSize);
                } else {
                    console.log('添加失败');
                    $modal.find('.alert').show();
                }
            },error: function(result){
            	$.LoadingOverlay("hide");
            }
        });
    });
    // 隐藏模态框时，清理校验状态
    $addMaterialModal.on('hidden.bs.modal', function () {
        resetForm($(this));
    }).on('show.bs.modal',function(){
    	var $type = $(this).find('form').find('[name=cargoLocationTypeId]');
    	loadLocationType($type,null);
    });
    
    // 编辑模态框
    $('#editMaterialModal').on('click', '.btn-primary', function () {
        // 提交表单
        $(this).parent().prev().find('form').submit();
    }).on('hidden.bs.modal', function () {
        // 隐藏模态框时，清理校验状态
        resetForm($(this));
    }).on('show.bs.modal', function (event) {
    	
        var button = $(event.relatedTarget); // Button that triggered the modal
        var id = button.data('id'); // Extract info from data-* attributes

        var modal = $(this);
        modal.find('[name=id]').val(id);
        
        $.getJSON($('#baseUrl').attr('href') + 'material/' + id, function (result) {
            if (result) {
                modal.find('[name=code]').val(result.code);
                modal.find('[name=length]').val(result.length);
                modal.find('[name=width]').val(result.width);
                modal.find('[name=height]').val(result.height);
                
                modal.find('[name=maxStore]').val(result.maxStore);
                modal.find('[name=faceUp]').prop("checked",result.faceUp);
                
                loadLocationType(modal.find('[name=cargoLocationTypeId]'),(result.cargoLocationTypeId ? result.cargoLocationTypeId : null));
                
                if(result.cargoLocationTypeId){
                	loadLocatioin(modal.find('[name=cargoLocationId]'),result.cargoLocationTypeId,result.cargoLocationId);
                }
            }
        });
    }).find('form').formValidation({
        framework: 'bootstrap',
        excluded: ':disabled',
        icon: {
            valid: 'fa fa-check',
            invalid: 'fa fa-times',
            validating: 'fa fa-refresh'
        },
        fields: $.extend(fileds,{
        	code: {
                validators: {
                    notEmpty: {
                        message: '物料编码不能为空'
                    },
                    remote: {
                    	url: $('#baseUrl').attr('href') + "material/findCodeIsExist",
                    	data : function(validator, $field, value){
                    		return {id : $('#editMaterialModal').find("[name=id]").val()};
                    	},
                        type: 'GET',
                        delay: 1000,
                        message:'物料编码已经存在'
                    }
                }
            }
        })
    }).on('success.form.fv', function (e) {
        // Prevent form submission
        e.preventDefault();

        var $form = $(e.target),
            fv = $form.data('formValidation'),
            $modal = $form.parent().parent().parent().parent();
        
        $.LoadingOverlay("show");
        $.ajax({
            url: $form.attr('action'),
            type: 'PATCH',
            data: $form.serialize(),
            success: function (result) {
            	$.LoadingOverlay("hide");
                if (result) {
                    console.log('编辑成功');
                    // 隐藏模态框
                    $modal.modal('hide');
                    // 重新加载数据
                    loadData(currentPage, currentSize);
                } else {
                    console.log('编辑失败');
                    $modal.find('.alert').show();
                }
            },error: function(result){
            	$.LoadingOverlay("hide");
            	console.log('编辑失败');
                $modal.find('.alert').show();
            }
        });
    });

    // 删除模态框
    $('#deleteMaterialModal').on('click', '.btn-danger', function () {
        var $form = $(this).parent().prev().find('form');
        var id = $form.find('[name=id]').val();
        var $modal = $(this).parent().parent().parent().parent();
        $.ajax({
            url: $form.attr('action') + '/' + id,
            type: 'DELETE',
            success: function (result) {
                if (result) {
                    console.log('删除成功');
                    // 隐藏模态框
                    $modal.modal('hide');
                    // 重新加载数据
                    loadData(currentPage, currentSize);
                }else{
                	alert("删除失败");
                }
            },error : function(result){
            	alert("删除失败");
            }
        });
    }).on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Button that triggered the modal
        var id = button.data('id'); // Extract info from data-* attributes
        var code = button.data('code'); // Extract info from data-* attributes

        var modal = $(this);
        modal.find('[name=id]').val(id);
        modal.find('.label-info').text(code);
    });
    
    //导入物料数据
    $('#importMaterialModal').on('click', '.btn-primary', function () {
        // 提交表单
        $(this).parent().prev().find('form').submit();
    }).on('hidden.bs.modal', function () {
        $(this).find('form').formValidation('resetForm', true);
        $(this).find('.alert').hide();
    }).find("form").formValidation({
        framework: 'bootstrap',
        excluded: ':disabled',
        icon: {
            valid: 'fa fa-check',
            invalid: 'fa fa-times',
            validating: 'fa fa-refresh'
        },
        fields: {
            file: {
                validators: {
                    notEmpty: {
                        message: '导入文件不能为空'
                    },
                    file: {
                    	extension : 'xlsx',
                    	message: '文件格式有误,应该是xlsx'
                    }
                }
            }
        }
    }).on('success.form.fv', function (e) {
        // Prevent form submission
        e.preventDefault();
        // Use Ajax to submit form data
        var $form = $(e.target),
        	fv = $form.data('formValidation'),
        	$modal = $form.parent().parent().parent().parent();
        
        var formdata = new FormData($form[0]);
        
        $.LoadingOverlay("show",{custom  : getCustomElement('正在导入物料，请耐心等待...')});
        $.ajax({
           type : 'post',
           url : $form.attr('action'),
           data : formdata,
           cache : false,
           processData : false, // 不处理发送的数据，因为data值是Formdata对象，不需要对数据做处理
           contentType : false, // 不设置Content-type请求头
           success : function(result){
        	   $.LoadingOverlay("hide");
        	   if (result.success) {
                   console.log('导入成功');
                   // 隐藏模态框
                   $modal.modal('hide');
                   // 重新加载数据
                   loadData(1, currentSize);
               } else {
                   console.log('导入失败');
                   if(result.msg){
                	   $("#importError").html(result.msg);
                   }else{
                	   $("#importError").html('导入物料失败,请重试!');
                   }
                   $modal.find('.alert').show();
               }
   	   	   },
           error : function(){
        	   $.LoadingOverlay("hide");
        	   console.log('导入失败');
        	   $("#importError").html('导入物料失败,请重试!');
               $modal.find('.alert').show();
   	       }
       });
    });
    
    //导入物料库存
    $('#updateStoreModal').on('click', '.btn-primary', function () {
        $(this).parent().prev().find('form').submit();
    }).on('hidden.bs.modal', function () {
    	$(this).find('form').formValidation('resetForm', true);
    	$(this).find('.alert').hide();
    }).find("form").formValidation({
        framework: 'bootstrap',
        excluded: ':disabled',
        icon: {
            valid: 'fa fa-check',
            invalid: 'fa fa-times',
            validating: 'fa fa-refresh'
        },
        fields: {
            file: {
                validators: {
                    notEmpty: {
                        message: '导入文件不能为空'
                    },
                    file: {
                    	extension : 'xlsx',
                    	message: '文件格式有误,应该是xlsx'
                    }
                }
            }
        }
    }).on('success.form.fv', function (e) {
        // Prevent form submission
        e.preventDefault();
        
        var $form = $(e.target),
        	fv = $form.data('formValidation'),
        	$modal = $form.parent().parent().parent().parent();
        
        var formdata = new FormData($form[0]);
        
        $.LoadingOverlay("show",{custom  : getCustomElement('正在更新物料库存，请耐心等待...')});
        $.ajax({
           type : 'post',
           url : $form.attr('action'),
           data : formdata,
           cache : false,
           processData : false, // 不处理发送的数据，因为data值是Formdata对象，不需要对数据做处理
           contentType : false, // 不设置Content-type请求头
           success : function(result){
        	   $.LoadingOverlay("hide");
        	   if (result.success) {
                   console.log('导入成功');
                   // 隐藏模态框
                   $modal.modal('hide');
                   // 重新加载数据
                   loadData(currentPage, currentSize);
               } else {
                   console.log('导入失败');
                   if(result.msg){
                	   $("#updateStoreError").html(result.msg);
                   }else{
                	   $("#updateStoreError").html('更新物料库存失败,请重试!');
                   }
                   $modal.find('.alert').show();
               }
   	   	   },
           error : function(){
        	   $.LoadingOverlay("hide");
        	   console.log('导入失败');
        	   $("#updateStoreError").html('更新物料库存失败,请重试!');
               $modal.find('.alert').show();
   	       }
       });
    });
});

// 重置modal
function resetForm($modal){
	var $form = $modal.find('form');
	$form.find('[type=text]').val('');
	$form.find('[type=checkbox]').prop("checked",false);
	$form.find('select').each(function(index,item){
		$(this).empty();
		$(this).append("<option value=''>请选择</option>");
	});
	$modal.find('.alert').hide();
	$form.formValidation('resetForm', true);
}

function loadLocationType(target,value){
	$.ajaxSettings.async = false;
	$.getJSON($('#baseUrl').attr('href') + 'cargo-location-type/list', function (result) {
        if (result) {
        	target.empty();
        	target.append("<option value=''>请选择</option>");
        	$(result).each(function(index,item){
        		if(value && item.id == value){
        			target.append("<option value='"+ item.id +"' selected>" + item.code + "</option>");
        		}else{
        			target.append("<option value='"+ item.id +"'>" + item.code + "</option>");
        		}
        	});
        }
    });
}

// 根据货位类型id加载货位
function loadLocatioin(target,typeId,value){
	if(typeId){
		$.getJSON($('#baseUrl').attr('href') + 'cargo-location/list?typeId=' + typeId, function (result) {
			target.empty();
            if (result) {
            	$(result).each(function(index,item){
            		if(value && item.id == value){
            			target.append("<option value='"+ item.id +"' selected>" + item.code + "</option>");
            		}else{
            			target.append("<option value='"+ item.id +"'>" + item.code + "</option>");
            		}
            	});
            }
        });
	}else{
		target.empty();
	}
}

/**
 * 加载数据
 * @param page 页码
 * @param size 数量
 */
function loadData(page, size) {

    currentSize = size;
    currentPage = page;

    var data = {
        code: $('.navbar-form').find('[name=code]').val() || '',
        optimalLocationType: $('.navbar-form').find('[name=optimalLocationType]').val() || '',
        recommendedLocationType: $('.navbar-form').find('[name=recommendedLocationType]').val() || '',
        page: page || 1,
        size: size || 10
    };

    // 获取数据
    $.get($('#baseUrl').attr('href') + 'material', data, function (result) {
        if (result) {
            // 清空表格
            $('#materialList').empty();

            // 添加数据到表格
            $.each(result.list, function (index, item) {
                $('#materialList').append('<tr>' +
                    '<td>' + (result.startRow + index) + '</td>' +
                    '<td>' + (item.code || '') + '</td>' +
                    '<td>' + (item.length || '') + '*' + (item.width || '') + '*' + (item.height || '') + '</td>' +
                    '<td>' + (item.maxStore || '') + '</td>' +
                    '<td class="newLine">' + (item.allAppropriateLibraryTypes || '') + '</td>' +
                    '<td class="newLine">' + (item.extendAllAppropriateLibraryTypes || '') + '</td>' +
                    '<td>' + (item.optimalLocationType || '') + '</td>' +
                    '<td>' + (item.optimalPlacement || '') + '</td>' +
                    '<td>' + (item.recommendedLocationType || '') + '</td>' +
                    '<td>' + (item.recommendedPlacement || '') + '</td>' +
                    '<td style="white-space:nowrap;">' +
                    	(updateFlag ? ('<button class="btn btn-primary" data-toggle="modal" data-target="#editMaterialModal" data-id="' + item.id + '"><i class="fa fa-edit"></i></button>') : '') +
                    	(deleteFlag ? ('<button class="btn btn-danger" data-toggle="modal" data-target="#deleteMaterialModal" data-id="' + item.id + '" data-code="' + item.code + '"><i class="fa fa-trash"></i></button>') : '') +
                    '</td>' +
                    '</tr>');
            });

            // 初始化分页控件
            $("#pagination").bs_pagination({
                currentPage: currentPage,
                totalRows: result.total,
                rowsPerPage: currentSize,
                totalPages: result.pages,
                onChangePage: function (event, data) {
                    console.log(event, data);
                    loadData(data.currentPage, data.rowsPerPage);
                }
            });
        } else {
            console.log('获取物料列表失败，请重试');
        }
    });
}