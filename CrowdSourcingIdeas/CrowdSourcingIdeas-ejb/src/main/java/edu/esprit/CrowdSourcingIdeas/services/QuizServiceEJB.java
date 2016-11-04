package edu.esprit.CrowdSourcingIdeas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.CrowdSourcingIdeas.persistence.Customer;
import edu.esprit.CrowdSourcingIdeas.persistence.Idea;
import edu.esprit.CrowdSourcingIdeas.persistence.Like2;
import edu.esprit.CrowdSourcingIdeas.persistence.Question;
import edu.esprit.CrowdSourcingIdeas.persistence.Quiz;

/**
 * Session Bean implementation class QuizServiceEJB
 */
@Stateless
@LocalBean
public class QuizServiceEJB implements QuizServiceEJBRemote {
	@PersistenceContext(name="CrowdSourcingIdeas-ejb") 
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public QuizServiceEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Quiz> afficherQuiz()
	{
		return	em.createQuery("SELECT e FROM Quiz e",Quiz.class).getResultList();
		
	}
	@Override
	public Quiz findQuizById(int idQuiz) {
		return em.find(Quiz.class,idQuiz);
	}
	
	
	public List<Question> findQuestions(Quiz quiz)
	{
	return em.createQuery("select e from Question e where e.quiz=:quiz")
	.setParameter("quiz", quiz).getResultList();
	}

	@Override
	public List<Question> findQuiz(int quiz ) {
		
		
		return em.createQuery(" FROM Question e where e.quiz.idQuiz LIKE :quiz")
				.setParameter("quiz",quiz)
				.getResultList();
		}

	@Override
	public int playQuiz() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez Choisir un quiz :");
		int str = sc.nextInt();
		System.out.println(str);
		List<Question> liste2 = new ArrayList<Question>();

		liste2 = this.findQuiz(str);
		int i = 1;
		int score = 0;
		for (Question l : liste2) {

			System.out.println("Question numero" + i + " \n" + l.getDescription());
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Veuillez Repondre :");

			String reponse = sc1.nextLine();

			if (reponse.equals(l.getAnswer())) {
				score++;
			}
		}
		return score;

	}

	@Override
	public void RemplirQuiz(Quiz q) {
		em.persist(q);	
	}

	@Override
	public void addQuizToCustomer(int numQuiz, int idCustomer) {
		
			Quiz b=em.find(Quiz.class,numQuiz);
			Customer p=em.find(Customer.class,idCustomer);
	            b.setCustomer(p);
		}

	@Override
	public List<Quiz> classementQuiz() {
	return	em.createQuery("SELECT e FROM Quiz e order by score desc",Quiz.class).getResultList();
		}
	}
		
	
		
	


	

	
	
	
	
	
	
	
	
	
	


