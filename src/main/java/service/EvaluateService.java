package service;

import bean.TEvaluate;
import org.springframework.stereotype.Service;

@Service
public interface EvaluateService {
    String evaluate(TEvaluate tEvaluate);
    String findEvaluation();
    String findBeEvaluation();
    String deleteTEvaluation(Integer evaid);
    String changeEvaluation(Integer evaid,String evaluation,Integer evaluatescore);
}
