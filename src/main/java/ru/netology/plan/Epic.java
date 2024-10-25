package ru.netology.plan;

public class Epic extends Task{

    protected String[] subTask = new String[0];

    public Epic(int id, String[] subTask) {
        super(id); // вызов родительского конструктора
        this.subTask = subTask; // заполнение своих полей
    }

    @Override
    public boolean matches(String quaery){
        for(String subTask : subTask){
            if (subTask.contains(quaery)){
                return true;
            }
        }
        return false;
    }

}
