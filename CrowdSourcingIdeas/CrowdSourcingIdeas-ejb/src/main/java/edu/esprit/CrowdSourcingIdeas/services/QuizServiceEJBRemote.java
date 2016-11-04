package edu.esprit.CrowdSourcingIdeas.services;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.CrowdSourcingIdeas.persistence.Question;
import edu.esprit.CrowdSourcingIdeas.persistence.Quiz;

@Remote
public interface QuizServiceEJBRemote {
public List<Quiz> afficherQuiz();

public List<Question> findQuestions(Quiz quiz);
public Quiz findQuizById(int idQuiz);
public List<Question> findQuiz(int quiz);
public int playQuiz();
public void RemplirQuiz(Quiz q);
public void addQuizToCustomer(int numQuiz,int idCustomer);
public List<Quiz> classementQuiz();
}
