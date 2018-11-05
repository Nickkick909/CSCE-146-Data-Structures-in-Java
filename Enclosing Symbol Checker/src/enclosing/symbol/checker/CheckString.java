/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enclosing.symbol.checker;

/**
 *
 * @author nicho
 */
public class CheckString {
    private GenericStack<Character> stack=new GenericStack<Character>();
    public boolean enclosing(String line){
        boolean found=true;
        for(int i=0; i<line.length()-1;i++){
            if(line.charAt(i)== '('){       //push openings to stack
                stack.push(line.charAt(i));
            }
            else if(line.charAt(i)== '['){
                stack.push(line.charAt(i));
            }
            else if(line.charAt(i)== '{'){
                stack.push(line.charAt(i));
            }
            else if(line.charAt(i)== '/'){
                if(line.charAt(i+1)== '*'){
                    stack.push(line.charAt(i));
                    stack.push(line.charAt(i+1));
                }
                
            }
            
            //pop if closing found
            if(line.charAt(i)== ')'){
                String parens="";
                    parens+=stack.pop();
                    if(parens.equals("(")){  //it is poped out in reserse order
                        found=true;
                    }
                    else 
                        found =false;
                        return found;
            }
            else if(line.charAt(i)== ']'){
                String bracket="";
                    bracket+=stack.pop();
                    if(bracket.equals("[")){  //it is poped out in reserse order
                        found=true;
                    }
                    else 
                        found =false;
                        return found;
            }
            else if(line.charAt(i)== '}'){
                String curly="";
                    curly+=stack.pop();
                    if(curly.equals("{")){  //it is poped out in reserse order
                        found=true;
                    }
                    else 
                        found =false;
                        return found;
            }
            else if(line.charAt(i)== '*'){
                if(line.charAt(i+1)== '/'){
                    int starCount=0;        //has to be at least a set of 2 *'s 
                    for(int j=0;j<line.length();j++){
                        if(line.charAt(j)== '*')
                            starCount++;      
                    }
                    if(starCount%2!=0){
                        found=false;
                        return false;
                    }
                    String blockComment="";
                    blockComment+=stack.pop();
                    blockComment+=stack.pop();
                    
                    if(blockComment.equals("*/")){  //it is poped out in reserse order
                        found=true;
                    }
                    else 
                        found =false;       
                        return found;
                }
            }
        }
        
       return found; 
    }
}
