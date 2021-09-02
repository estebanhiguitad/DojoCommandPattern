package command.ceiba.com.co.dojocommandpattern

class NotificationInvoker(private val command : ICommand) {
    fun execute() {
        command.execute()
    }
}