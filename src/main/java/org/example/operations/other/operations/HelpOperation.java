package org.example.operations.other.operations;

import org.example.operations.other.OtherOperation;

import static org.example.operations.OperationsList.operationsList;

public class HelpOperation extends OtherOperation {

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "выводит информацию о доступных командах";
    }

    public String getHelp(){
        final var help = new StringBuilder();
        for (var o:operationsList){
            help.append(o.getName()).append(": ").append(o.getDescription()).append("\n");
        }
        return help.toString();
    }

}
