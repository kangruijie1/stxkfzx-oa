package xyz.stxkfzx.manager.face.ai.pojo;

public class AiSelAllUserIdBase extends  AiBase{
    private AiSelAllUserIdResult result;

    public AiSelAllUserIdResult getResult() {
        return result;
    }

    public void setResult(AiSelAllUserIdResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "AiSelAllUserIdBase{" +
                "result=" + result +
                '}';
    }
}
