/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (statement.indexOf("no") >= 0)
        {
            response = "How about yes?";
        }
        else if (statement.indexOf("mother") >= 0
                || statement.indexOf("sister") >= 0)
        {
            response = "Tell me more about your family.";
        }
        else if (statement.indexOf("father") >= 0)
        {
            statement = "What is your dad's name?";
        }
        else if (statement.indexOf("brother") >= 0)
        {
            response = "I have a brother too!";
        }
        else if (statement.indexOf("dog") >= 0
                || statement.indexOf("cat") >= 0)
        {
            response = "Tell me more about your pets.";
        }
        else if (statement.indexOf("Nathan") >= 0)
        {
            response = "He seems like a good teacher.";
        }
        else if (statement.indexOf("run") >= 0)
        {
            response = "I like to run also!";
        }
        else if (statement.indexOf("phone") >= 0)
        {
            response = "What phone do you have?";
        }
        else if (statement.trim().length() == 0)
        {
            response = "Say something, please.";
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    public String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 4;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
    
        return response;
    }

    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that 
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization 
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise. 
    public int findWord(String str, String word) {
        str = str.toLowerCase();
        word = word.toLowerCase();
    
        return str.indexOf(word);
    }

    
    // We will work on the following methods later!

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement)
    {
        statement = statement.trim();
        String a = statement.substring(statement.length() - 1);
        if (a.equals(".")){
            statement = statement.substring(statement.length() - 1);
        }
        int b = findWord(statement, "I want");
        String c = statement.substring(b + 7);
        return ("Would you really be happy if you had " + c + "?");

    }

    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement)
    {
        String a = statement.substring(findWord(statement, "i" ) + 2, findWord(statement, "you") -1 );
        return ("Why do you " + a + " me?");
    }

    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement)
    {
        statement = statement.trim();
        String a = statement.substring(statement.length() - 1);
        if (a.equals(".")){
            statement = statement.substring(statement.length() - 1);
        }
        int b = findWord(statement, "I want to");
        String c = statement.substring(b + 9).trim();
        return ("What would it mean to " + c + "?");
    }




    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
        String a = statement.substring(findWord(statement, "you") + 3, findWord(statement, "me") -1);
        return ("What makes you think that I" + a +" you?");
    }
}