/**
 * 
 */
package com.sddevops.selenium_EcommerceClothesProject;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * @author Ernes
 *
 */
class FeedbackCollectionTest {
	
	
	private FeedbackCollection fc;
    private Feedback f1;
    private Feedback f2;
    private Feedback f3;
    private Feedback f4;
    private final int FEEDBACK_COLLECTION_SIZE = 4;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
		 fc = new FeedbackCollection();
	        f1 = new Feedback(1, "Hi" );
	        f2 = new Feedback(2, "Hello");
	        f3 = new Feedback(3, "Bye" );
	        f4 = new Feedback(4, "Sayonara");
	        fc.addFeedback(f1);
	        fc.addFeedback(f2);
	        fc.addFeedback(f3);
	        fc.addFeedback(f4);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	

	/**
	 * Test method for {@link com.sddevops.selenium_EcommerceClothesProject.FeedbackCollection#addFeedback(com.sddevops.selenium_EcommerceClothesProject.Feedback)}.
	 */
	@Test
	void testAddFeedback() {
        List<Feedback> testFc = fc.getFeedbacks();
        //Assert that  Collection is equals to feedback collection size 4
        assertEquals(testFc.size(), FEEDBACK_COLLECTION_SIZE);
        //Act
        fc.addFeedback(f1);
        //Assert that Feedback Collection is equals to song collection size 4 + 1
        assertEquals(fc.getFeedbacks().size(), FEEDBACK_COLLECTION_SIZE+1);
		
	}


}
