package vbox;

import org.virtualbox_4_1.*;

import java.util.List;

/**
 * Created by gridfusion on 04/10/15.
 */
public class VboxCommands {

    public void stopMachine(VirtualBoxManager mgr) {

        VirtualBoxManager mgr1 = VirtualBoxManager.createInstance(null);
        IVirtualBox handle;

        mgr1.connect("http://localhost:18083", "", "");

        System.out.println("Initialized connection to VirtualBox version " + mgr1.getVBox());
        handle = mgr1.getVBox();
        System.out.println("Home folder: " + handle.getHomeFolder());

        List<IMachine> machines =  handle.getMachines();
        System.out.println("Number of machines: " + machines.size());
        IMachine machine = machines.get(0);
        System.out.println("Machine name: " + machine.getName());



    }


    public void startVM(VirtualBoxManager mgr, IMachine machine) {

        ISession session = mgr.getSessionObject();
        IProgress prog = machine.launchVMProcess(session,
                "gui",  // session type
                "");    // possibly environment setting
        prog.waitForCompletion(10000);  // give the process 10 secs


        if (prog.getResultCode() != 0)  // check success
            System.out.println("Cannot launch VM!");
    }

    public MachineState getCurrentState(VirtualBoxManager mgr, IMachine machine) {

        /*
        MachineState state = machine.getState();

        System.out.println("Initial machine state: " + machine.getState());

        while(machine.getState() != MachineState.Running)
        {
            System.out.println("Machine state: " + machine.getState());

        }
        */

        return machine.getState();

    }




}
