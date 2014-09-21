package com.itravel.smzdw.dao;

public final class NavigationMenuItem {
	private int label;
	private String text;
	public NavigationMenuItem(int label,String text) {
		// TODO Auto-generated constructor stub
		this.label = label;
		this.text = text;
	}
	public int getLabel() {
		return label;
	}
	public void setLabel(int label) {
		this.label = label;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
