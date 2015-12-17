
package com.yazao.news.lib.net;

import com.yazao.news.lib.util.net.NetUtil;

public interface NetChangeObserver {

	/**
	 * when network connected callback
	 */
	 void onNetConnected(NetUtil.NetType type);

	/**
	 *  when network disconnected callback
	 */
	 void onNetDisConnect() ;
}
