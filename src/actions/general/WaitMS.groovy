package actions.general

class WaitMS{
  
  public run(def params){
    if(params.milliseconds){
    	sleep(params.milliseconds.toInteger() )  
    }    
  }
}