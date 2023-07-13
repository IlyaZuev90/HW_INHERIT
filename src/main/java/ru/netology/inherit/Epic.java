package ru.netology.inherit;

public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks; // заполнение своих полей
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        String[] tmp = new String[subtasks.length];
        for (int i = 0; i < subtasks.length; i++) {
            tmp[i] = subtasks[i];
            if (tmp[i].contains(query)) {
                return true;
            }
        }
        return false;
    }
}
