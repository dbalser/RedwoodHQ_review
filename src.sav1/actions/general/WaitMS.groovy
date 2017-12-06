package actions.general

class WaitMS{
  
  public run(def params){
	long startTime = System.currentTimeMillis()
  	System.out.println("InTicks=" + (startTime % 100000)/1000 )
	if(params.milliseconds){
    	sleep(params.milliseconds.toInteger() )  
    }    
    long endTime = System.currentTimeMillis()
    System.out.println("OutTicks=" + (endTime % 100000)/1000 )
    System.out.println("====>Duration ="+ (endTime - startTime)/1000); System.out.println(" ")
  }
}