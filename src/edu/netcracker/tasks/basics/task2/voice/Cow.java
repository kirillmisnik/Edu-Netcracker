package edu.netcracker.tasks.task2.voice;

public class Cow implements Voice {
    /**
     * Подаёт голос (выводит сообщение в консоль)
     */
    @Override
    public void voice() {
        System.out.println("Moo");
    }
}
