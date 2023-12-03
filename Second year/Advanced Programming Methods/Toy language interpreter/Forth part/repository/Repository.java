package repository;

import exceptions.MyException;
import model.programState.ProgramState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Repository implements IRepository{
    private List<ProgramState> programStates;
    private  final String logFilePath ;

    public Repository(ProgramState programState, String logFilePath){
        this.programStates = new ArrayList<>();
        this.addProgram(programState);
        this.logFilePath = logFilePath;
    }



    @Override
    public List<ProgramState> getProgramList(){
        return this.programStates;
    }

    @Override
    public void setProgramState(List<ProgramState> prStates){
        this.programStates = prStates;
    }

    @Override
    public void addProgram(ProgramState pr){
        this.programStates.add(pr);
    }

    @Override
    public void logPrgStateExec() throws IOException, MyException {
        PrintWriter logFile;
        logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
        logFile.println(this.programStates.get(0).programStateToString());
        logFile.close();

    }




    @Override
    public ProgramState getCurrentState(){
        return this.programStates.get(0);
    }
}
