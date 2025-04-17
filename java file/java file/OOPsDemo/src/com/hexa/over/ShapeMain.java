package com.hexa.over;

public class ShapeMain {

	public static void main(String[] args) {
		Shape shape=new Shape();
		shape.area(4);
		shape.area(10.0);
		int rect =shape.area(2,3);
		System.out.println("rect"+rect);
		
		

	}

}
