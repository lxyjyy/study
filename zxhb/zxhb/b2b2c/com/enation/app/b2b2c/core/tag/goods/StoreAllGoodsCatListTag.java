package com.enation.app.b2b2c.core.tag.goods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.enation.app.b2b2c.core.model.member.StoreMember;
import com.enation.app.b2b2c.core.service.goods.IStoreGoodsCatManager;
import com.enation.app.b2b2c.core.service.member.IStoreMemberManager;
import com.enation.framework.context.webcontext.ThreadContextHolder;
import com.enation.framework.taglib.BaseFreeMarkerTag;

import freemarker.template.TemplateModelException;

/**
 * 
 * 店铺分类列表标签
 * @author xulipeng
 * 2014年10月8日20:24:57
 * 
 */

@Component
public class StoreAllGoodsCatListTag extends BaseFreeMarkerTag {
	
	private IStoreGoodsCatManager storeGoodsCatManager;
	private IStoreMemberManager storeMemberManager;
	
	@Override
	protected Object exec(Map params) throws TemplateModelException {
		Integer storeid = (Integer) params.get("storeid");
		if(storeid==null || storeid==0){
			StoreMember storeMember = storeMemberManager.getStoreMember();;
			storeid = storeMember.getStore_id();
		}
		List list =new ArrayList();
		return this.storeGoodsCatManager.storeAllCatList(storeid);
	}
	public IStoreMemberManager getStoreMemberManager() {
		return storeMemberManager;
	}

	public void setStoreMemberManager(IStoreMemberManager storeMemberManager) {
		this.storeMemberManager = storeMemberManager;
	}

	public IStoreGoodsCatManager getStoreGoodsCatManager() {
		return storeGoodsCatManager;
	}

	public void setStoreGoodsCatManager(IStoreGoodsCatManager storeGoodsCatManager) {
		this.storeGoodsCatManager = storeGoodsCatManager;
	}

	
}
