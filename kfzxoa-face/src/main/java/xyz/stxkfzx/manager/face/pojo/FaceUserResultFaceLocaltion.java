package xyz.stxkfzx.manager.face.pojo;

public class FaceUserResultFaceLocaltion
{
    private String left;
    private String top;
    private String width;
    private String height;
    private String rotation;
    
    public FaceUserResultFaceLocaltion(final String left, final String top, final String width, final String height, final String rotation) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
        this.rotation = rotation;
    }
    
    public FaceUserResultFaceLocaltion() {
    }
    
    public String getLeft() {
        return this.left;
    }
    
    public void setLeft(final String left) {
        this.left = left;
    }
    
    public String getTop() {
        return this.top;
    }
    
    public void setTop(final String top) {
        this.top = top;
    }
    
    public String getWidth() {
        return this.width;
    }
    
    public void setWidth(final String width) {
        this.width = width;
    }
    
    public String getHeight() {
        return this.height;
    }
    
    public void setHeight(final String height) {
        this.height = height;
    }
    
    public String getRotation() {
        return this.rotation;
    }
    
    public void setRotation(final String rotation) {
        this.rotation = rotation;
    }
    
    public String toString() {
        return "FaceUserResultFaceLocaltion [left=" + this.left + ", top=" + this.top + ", width=" + this.width + ", height=" + this.height + ", rotation=" + this.rotation + "]";
    }
}
