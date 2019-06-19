package xyz.stxkfzx.manager.face.ai.pojo;

public class AiSelUserInfoBase extends AiBase{
    private AiSelUserInfoResult result;

    @Override
    public String toString() {
        return "AiSelUserInfoBase{" +
                "result=" + result +
                '}';
    }

    public AiSelUserInfoResult getResult() {
        return result;
    }

    public void setResult(AiSelUserInfoResult result) {
        this.result = result;
    }
}
