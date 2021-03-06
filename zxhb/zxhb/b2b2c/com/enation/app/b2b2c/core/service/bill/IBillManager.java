package com.enation.app.b2b2c.core.service.bill;

import java.util.List;

import com.enation.app.b2b2c.core.model.bill.Bill;
import com.enation.app.b2b2c.core.model.bill.BillDetail;
import com.enation.framework.database.Page;
/**
 * 平台结算管理类
 * @author fenlongli
 *
 */
public interface IBillManager {
	/**
	 * 获取结算单分页列表
	 * @param pageNO 页码
	 * @param pageSize 每页显示数量
	 * @return
	 */
	public Page bill_list(Integer pageNo,Integer pageSize);
	
	/**
	 * 结算单详细列表
	 * @param pageNo 页码
	 * @param pageSize 每页显示数量
	 * @param bill_id 结算单Id
	 * @param keyword 搜索关键字(店铺名称关键字)
	 * @return
	 */
	public Page bill_detail_list(Integer pageNo,Integer pageSize,Integer bill_id,String keyword);
	/**
	 * 店铺结算单列表
	 * @param pageNo  页码
	 * @param pageSize 每页显示数量
	 * @param store_id 店铺Id
	 * @return
	 */
	public Page store_bill_detail_list(Integer pageNo,Integer pageSize,Integer store_id);
	
	/**
	 * 结算单
	 * @param bill
	 * @return
	 */
	public void add_bill(Integer store_id,double price);
	
	/**
	 * 添加结算单详细
	 * @param billDetail
	 */
	public void add_bill_detail(BillDetail billDetail);
	/**
	 * 获取结算详细单
	 * @param id 详细单Id
	 * @return
	 */
	public BillDetail get_bill_detail(Integer id);
	
	/**
	 * 更改结算详细单状态
	 * @param id 详细单Id
	 * @param status 状态
	 */
	public void edit_billdetail_status(Integer id,Integer status);
	
	/**
	 * 获取结算的订单列表
	 * @param sn 结算详细单编号
	 * @param pageNo 页码
	 * @param pageSize 每页显示数量
	 * @return 结算的订单列表
	 */
	public Page bill_order_list(Integer pageNo,Integer pageSize,String sn);
	/**
	 * 获取结算的退货单列表
	 * @param pageNo
	 * @param pageSize
	 * @param sn
	 * @return
	 */
	public Page bill_sell_back_list(Integer pageNo,Integer pageSize,String sn);
	
}
