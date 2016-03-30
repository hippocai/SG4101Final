package com.icon;

import java.awt.Image;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class IconManager {
	private static Map<String,URL>iconMap=new HashMap<String,URL>();
	public static void initIcon(){
		iconMap.put("home", IconManager.class.getResource("home.png"));
		iconMap.put("back", IconManager.class.getResource("arrow-round.png"));
		iconMap.put("print", IconManager.class.getResource("print.png"));
		iconMap.put("clear", IconManager.class.getResource("recycle-full.png"));
		iconMap.put("pay", IconManager.class.getResource("payment.png"));
		iconMap.put("replenish",  IconManager.class.getResource("replenish.png"));
		iconMap.put("member",  IconManager.class.getResource("member.png"));
		iconMap.put("newProduct",  IconManager.class.getResource("newproduct.png"));
		iconMap.put("logout", IconManager.class.getResource("logoff.png"));
	}
	public static ImageIcon getIcon(String name){
		if(!iconMap.containsKey(name)){
			return null;
		}
		URL url=iconMap.get(name);
		ImageIcon icon=new ImageIcon(url);
		return icon;
	}
}
