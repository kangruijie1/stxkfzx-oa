/**
  * Copyright 2019 bejson.com 
  */
package com.besjon.pojo;

/**
 * Auto-generated: 2019-06-02 15:20:26
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Location {

    @Override
	public String toString() {
		return "Location [left=" + left + ", top=" + top + ", width=" + width + ", height=" + height + ", rotation="
				+ rotation + "]";
	}
	private double left;
    private double top;
    private int width;
    private int height;
    private int rotation;
    public void setLeft(double left) {
         this.left = left;
     }
     public double getLeft() {
         return left;
     }

    public void setTop(double top) {
         this.top = top;
     }
     public double getTop() {
         return top;
     }

    public void setWidth(int width) {
         this.width = width;
     }
     public int getWidth() {
         return width;
     }

    public void setHeight(int height) {
         this.height = height;
     }
     public int getHeight() {
         return height;
     }

    public void setRotation(int rotation) {
         this.rotation = rotation;
     }
     public int getRotation() {
         return rotation;
     }

}