import java.util.Random;
import java.util.Scanner;
public class WordJumble extends Game
{
  protected String word;
  protected int min;
  protected int max;
  protected WordsList words;
  protected int[] holder;
  protected String jumbled;
  protected String[] holder2;
  public String getName()
  {
    return "WordJumble";
  }
  protected boolean isOver()
  {
    if (this.guess.equals("quit"))
    {
      return true;
    }
     if(this.guess.equals(word))
    {
      return true;
    }
    if (rounds<round)
    {
      return true;
    }
    return false;
  }
  public WordJumble(WordsList words,Random rng,int min, int max, int maxguess)
  {
    this.words = words;
    this.min = min;
    this.max = max;
    this.rounds = maxguess;
    this.random=rng;
  }
  protected String processMove(String move)
  {
    this.guess=move;
    if (this.guess.equals("quit"))
    {
      return ("bye");
    }
    round+=1;
    if(this.guess.equals(word))
    {
      return(this.finalMessage());
    }
    else
    {
      return "That's not it\n";
    }

  }
  
    protected String prepToPlay()
  {
    this.jumbled="";
    word=words.getWord(min,max);
    holder=new int[word.length()];
    holder2=new String[word.length()];
    String x = "";
    for(int i=0;i<word.length();i++)
    {
      holder[i]=random.nextInt(word.length());
      holder2[i]=word.substring(i,i+1);
    }
    
        for(int i=0;i<word.length();i++)
        {
          x=holder2[i];
          holder2[i]=holder2[holder[i]];
          holder2[holder[i]]=x;
        }
      for(int i=0;i<word.length();i++)
        {
          this.jumbled += holder2[i];
        }
            round=1;
        return("The following is a jumbled up word: "+jumbled+" You get "+rounds+" guesses to guess it");


    
    


  }
   protected boolean isValid(String move)
  {
    return true;
      
  }
   protected String finalMessage()
  {
    return("The word was "+word+"\n");
  }
}

