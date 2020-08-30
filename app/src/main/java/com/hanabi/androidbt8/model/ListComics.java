package com.hanabi.androidbt8.model;

import com.hanabi.androidbt8.R;

import java.util.ArrayList;
import java.util.Date;

public class ListComics {

    private static ArrayList<Comic> comics;

    public static ArrayList<Comic> getComics() {
        initData();
        return comics;
    }

    private static void initData() {
        comics = new ArrayList<>();
        String content = "Nhân vật chính của câu chuyện là chú sói Legosi, một thành viên của của câu chuyện là chú sói Legosi, một thành viên của của câu chuyện là chú sói Legosi, một thành viên của của câu chuyện là chú sói Legosi, một thành viên của của câu chuyện là chú sói Legosi, một thành viên của của câu chuyện là chú sói Legosi, một thành viên của của câu chuyện là chú sói Legosi, một thành viên của của câu chuyện là chú sói Legosi, một thành viên của của câu chuyện là chú sói Legosi, một thành viên của của câu chuyện là chú sói Legosi, một thành viên của của câu chuyện là chú sói Legosi, một thành viên của của câu chuyện là chú sói Legosi, một thành viên của của câu chuyện là chú sói Legosi, một thành viên của  câu lạc bộ kịch nghệ. Mặc dù cậu có vẻ ngoài đáng sợ, cậu là một người có trái tim rất nhân hậu. Trong suốt cuộc đời của mình, cậu luôn là đối tượng của sự sợ hãi và hận thù của những loài vật khác, và cậu đã khá quen với lối sống đó. Nhưng rồi, cậu dần mở rộng lòng với những bạn học khác, những người cũng có nỗi lo của riêng mình và thấy cuộc sống của cậu ở trường đang chậm rãi thay đổi.";
        for (int i = 0; i < 100; i++) {
            comics.add(new Comic(i, R.drawable.ikenai_kanojo_no_otetsudai, "Không dõ " + i, "123+i" + i, "akana" + i, new Date(), content));
        }
    }
}
