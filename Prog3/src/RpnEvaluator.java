/**
This Class controls required operations such as the sum, difference and 
multiplication of vectors.
@author manjukl
*/
public class RpnEvaluator 
{
   private Stack s = new Stack(100);
   private boolean valid = true;
   private String expression = "";
   private TVector result = null;
   
   /**
   This method splits rpn into tokens and carries out some mathematical 
   operations, which sets valid to true if the evaluation was successful and 
   sets valid to false if it was not.
   @param rpn id the passed expression to be evaluated 
   @return true if evaluation was successfully carried out and false if not 
   */
   public boolean evalution (String rpn)
   {
      String []token  = rpn.split(" ");
      expression = "";
      for(int i = 0; i < token.length ; i++)
      {
         if(token[i].length() == 0)
         {}
         else if(token[i].charAt(0) == '+')
            sumEval();
         else if(token[i].charAt(0) == '-')
            subtractEval();
         else if(token[i].charAt(0) == '*')
            multiplyEval();
         else if(token[i].charAt(0) == '(')
            valid = pushToExpression(token, i);
         else 
            valid = isNotValidExpression(token, i);
         if(valid == false)
         {
            expression += token[i];
            return valid;
         }
      }
      if(s.isEmpty())
         return false;
      result = (TVector) s.pop();
      if(s.isEmpty())
         return true;
      return false;
   }  
   
   /**
   This method adds the current value in token[i] to the expression
   @param token is an array of token
   @param i is the index in the array 
   @return true if it successfully pushes the current value in token[i] to
   the array
   */
   public boolean pushToExpression( String [] token, int i)
   {
      try
      {
         TVector vect = new TVector(token[i]);
         s.push(vect);
         expression += vect.toString();
      }
      catch(Exception e)
      {
         expression += token[i];
         return false;
      }
      return true;
   }
   
   /**
   This method simply returns true if valid is false;
   @param token is an array of token
   @param i is the index in the array 
   @return true if valid is false
   */
   public boolean isNotValidExpression(String []token,int i)
   {
      valid = false;
      return valid;
   }
   
   /**
   This method adds two vectors in the stack by "popping" the vectors and
   returns the result to the stack
   @return true if it adds two vectors together successfully
   */
   public boolean sumEval()
   {
      if(s.isEmpty())
      {
         valid = false;
         return valid;
      }
      TVector tv1 = (TVector)s.pop();
      if(s.isEmpty() )
      {
         valid = false;
         return valid;
          
      }
      TVector tv2 = (TVector)s.pop();
      s.push(tv1.sum(tv2));
      expression += '+';
      return true;
   }
   
   /**
   This method subtracts a vector from another vector by "popping" the 
   vectors and returns the result to the stack.
   returns the result to the stack
   @return true if it subtracts successfully
   */
   public boolean subtractEval()
   {
      if(s.isEmpty())
      {
         valid = false;
         return valid;
      }
      TVector tv1 = (TVector)s.pop();

      if(s.isEmpty())
      {
         valid = false;
         return valid;
      }
      TVector tv2 = (TVector)s.pop();
      s.push(tv2.subtract(tv1));
      expression += '-';
      return true;
   }
    
   /**
   This method multiplies two vectors in the stack by "popping" the vectors
   and returns the result to the stack
   @return true if it multiplies successfully
   */
   public boolean multiplyEval()
   {
      if(s.isEmpty())
      {
         valid = false;
         return valid;
      }
      TVector tv1 = (TVector)s.pop();

      if(s.isEmpty())
      {
         valid = false;
         return valid;
      }
      TVector tv2 = (TVector)s.pop();
      s.push(tv1.multiply(tv2));
      expression += '*';
      return true;
   }
   
   /**
   This method results the result of the evaluation
   @return result of the evaluation (sumEval, subtractEval and multiplyEval)
   */
   public TVector getResult()
   {
      return result;
   }
   
   /**
   This method returns the final expression
   @return String of the final expression
   */
   public String getExpress()
   {
      return expression;
   }
}
