package xyz.stxkfzx.manager.face.ai.pojo;

public class AiSelAllGroupBase extends AiBase{
    private AiSelAllGroupResult result;

    public AiSelAllGroupResult getResult() {
        return result;
    }

    public void setResult(AiSelAllGroupResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "AiSelAllGroupBase{" +
                "result=" + result +
                '}';
    }
}
