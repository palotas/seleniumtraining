package vbox;

import org.virtualbox_4_1.IMachine;
import org.virtualbox_4_1.ISession;
import org.virtualbox_4_1.IVirtualBox;
import org.virtualbox_4_1.VirtualBoxManager;

import java.util.List;


public class VboxMain
{




    public static void main(String [ ] args)
    {

        VirtualBoxManager mgr = VirtualBoxManager.createInstance(null);
        IVirtualBox handle;

        mgr.connect("http://localhost:18083", "", "");

        System.out.println("Initialized connection to VirtualBox version " + mgr.getVBox());

        handle = mgr.getVBox();
        List<IMachine> machines =  handle.getMachines();
        System.out.println("Number of machines: " + machines.size());
        IMachine machine = machines.get(0);
        System.out.println("Machine name: " + machine.getName());

        VboxCommands myMachine = new VboxCommands();
        myMachine.startVM(mgr, machine);
        myMachine.getCurrentState(mgr, machine);

        ISession session = mgr.getSessionObject();


    }


}