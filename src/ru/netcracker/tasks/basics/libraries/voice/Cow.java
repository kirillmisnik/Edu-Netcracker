package ru.netcracker.tasks.basics.libraries.voice;

public class Cow implements Voice {
    /**
     * Подаёт голос (выводит сообщение в консоль)
     */
    @Override
    public void voice() {
        System.out.println("Moo");
    }
}
