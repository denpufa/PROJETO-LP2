package projetinho.telegram.com.company;

/**
 * @brief  SendMessage class is responsible for ...
 */
public class SendMessage {
    /**
     * @brief SendMessage class attributes.
     */
    private int chatId;
    private String text;

    /**
     * @brief Getters.
     */
    public int getChatId() {
        return chatId;
    }

    public String getText() {
        return text;
    }

    /**
     * @brief Setters.
     */
    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public void setText(String text) {
        this.text = text;
    }
}
