package com.eden.eva.util;

public class ContentUtils {

	public static String replaceBrackets(String content)
	{
		content = content.replaceAll("<","щ").replaceAll(">", "Ψ");
		return content;
	}
}
