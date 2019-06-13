package xyz.stxkfzx.manager.face.pojo;

/**
 * @author VicterTian
 * @version V1.0
 * @date 2019/6/12
 */
public class TSignItemImg {
    private Integer signItemImgId;
    private Integer signItemId;
    private short signItemType;
    private String signItemImg;

    public TSignItemImg() {
    }

    public Integer getSignItemImgId() {
        return signItemImgId;
    }

    public void setSignItemImgId(Integer signItemImgId) {
        this.signItemImgId = signItemImgId;
    }

    public Integer getSignItemId() {
        return signItemId;
    }

    public void setSignItemId(Integer signItemId) {
        this.signItemId = signItemId;
    }

    public short getSignItemType() {
        return signItemType;
    }

    public void setSignItemType(short signItemType) {
        this.signItemType = signItemType;
    }

    public String getSignItemImg() {
        return signItemImg;
    }

    public void setSignItemImg(String signItemImg) {
        this.signItemImg = signItemImg;
    }

    @Override
    public String toString() {
        return "TSignItemImg{" +
                "signItemImgId=" + signItemImgId +
                ", signItemId=" + signItemId +
                ", signItemType=" + signItemType +
                ", signItemImg='" + signItemImg + '\'' +
                '}';
    }
}
