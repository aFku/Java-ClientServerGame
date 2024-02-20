package org.rcbg.afku.clientservergame;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreadManager { // Singleton

    private List<Thread> lobbies = new ArrayList<>();
    private Set<Integer> portPool = IntStream.rangeClosed(30000, 30500).boxed().collect(Collectors.toSet());

    public ThreadManager(){
    }

    public void createMenuThread(Socket socket){
        new MenuThread(socket).start();
    }

    public void createGameThread(){
        return;
    }

    public void killThreadWithId(int id){
        return;
    }

    public void killAllThreads(){
        return;
    }

}
