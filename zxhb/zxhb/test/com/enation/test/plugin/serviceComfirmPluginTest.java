package com.enation.test.plugin;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.Ordered;

import com.enation.app.base.core.plugin.job.IErverDayZeroThirtyExecuteEvent;
import com.enation.app.shop.core.model.Order;
import com.enation.app.shop.core.plugin.order.IOrderConfirmPayEvent;
import com.enation.framework.test.SpringTestSupport;

public class serviceComfirmPluginTest extends SpringTestSupport{
	@Before
	public void mock(){
		
	}
	
	@Test
	public void IErverDayZeroThirtyExecuteEvent(){//结算定时认识测试
		IErverDayZeroThirtyExecuteEvent event = this.getBean("timeOutSettlementPlugin");
		event.everyDayZeroThirty();
		
	}
}
