/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory;
import eduni.simjava.*;
import eduni.simjava.distributions.Sim_negexp_obj;
import eduni.simjava.distributions.Sim_normal_obj;
/**
 *
 * @author win7
 */
public class supplier extends Sim_entity {
    private Sim_port in,out;
     private Sim_negexp_obj delay1;
     private double delay2;
     
     
    public supplier(String name,double mean) {
        super(name);
        delay1=new Sim_negexp_obj("delay", mean);
        delay2=this.delay2;
         out= new Sim_port("out");
        add_port(out);
        in = new Sim_port ("in");
        add_port(in);
        
    }
    public void body(){
        while (Sim_system.running()){ 
        Sim_event e  = new Sim_event (); 
        sim_get_next(e);
           sim_get_next(new Sim_from_p(Sim_system.get_entity_id("company")),e);
     sim_process (delay1.sample());
     sim_completed(e);
      sim_schedule(out,0.0,1);
    sim_pause(delay2);
    
    }
}
}