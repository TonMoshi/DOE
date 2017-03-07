/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


/**
 *
 * @author Dani
 */
public class MoveAct{

    private Controller controller;
        
    public MoveAct(Controller controller){
        this.controller = controller;
    }
    
    public void run() {
        int j=0;
        for(int i=0;i<controller.getListObjMov().size();i++){
            if(controller.getListObjMov().get(i).reach(controller.getPosObjMov().get(j), controller.getPosObjMov().get(j+1))){
                controller.getListObjMov().remove(i);
                controller.getPosObjMov().remove(j);
                controller.getPosObjMov().remove(j);
                i--;
            }else{
                controller.getListObjMov().get(i).move(controller.getPosObjMov().get(j), controller.getPosObjMov().get(j+1));
                j = j+2;
            }
        }  
    }
    
}
