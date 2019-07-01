package bean;

public class TEvaluate {
    private Integer evaid;

    private Long evaluatorId;

    private String evaluatorName;

    private Long beevaluatorId;

    private String beevaluatorName;

    private String evaluation;

    private Integer evaluatescore;

    public Integer getEvaid() {
        return evaid;
    }

    public void setEvaid(Integer evaid) {
        this.evaid = evaid;
    }

    public Long getEvaluatorId() {
        return evaluatorId;
    }

    public void setEvaluatorId(Long evaluatorId) {
        this.evaluatorId = evaluatorId;
    }

    public String getEvaluatorName() {
        return evaluatorName;
    }

    public void setEvaluatorName(String evaluatorName) {
        this.evaluatorName = evaluatorName == null ? null : evaluatorName.trim();
    }

    public Long getBeevaluatorId() {
        return beevaluatorId;
    }

    public void setBeevaluatorId(Long beevaluatorId) {
        this.beevaluatorId = beevaluatorId;
    }

    public String getBeevaluatorName() {
        return beevaluatorName;
    }

    public void setBeevaluatorName(String beevaluatorName) {
        this.beevaluatorName = beevaluatorName == null ? null : beevaluatorName.trim();
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation == null ? null : evaluation.trim();
    }

    public Integer getEvaluatescore() {
        return evaluatescore;
    }

    public void setEvaluatescore(Integer evaluatescore) {
        this.evaluatescore = evaluatescore;
    }
}