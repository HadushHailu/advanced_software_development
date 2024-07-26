package bank.service;

public interface ICommand {
    void execute();
    void unExecute();
}
