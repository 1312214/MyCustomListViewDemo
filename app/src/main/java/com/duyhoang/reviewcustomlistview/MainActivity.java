package com.duyhoang.reviewcustomlistview;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static String[] items={"lorem", "ipsum", "dolor",
            "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "augue", "purus"};
    ListView mListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView)findViewById(R.id.list_show_item);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 0, items){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
				ViewHolder viewHolder;
                if(convertView == null){
                    convertView = getLayoutInflater().inflate(R.layout.layout_row, null, false);
                    viewHolder = new ViewHolder();
                    viewHolder.avatar = (ImageView)convertView.findViewById(R.id.image_avatar);
                    viewHolder.mainText = (TextView)convertView.findViewById(R.id.text_main_content);
                    viewHolder.subText = (TextView)convertView.findViewById(R.id.text_sub_content);
                    convertView.setTag(viewHolder);
                }

                viewHolder = (ViewHolder) convertView.getTag();
                viewHolder.avatar.setImageResource(R.drawable.avatar);
                viewHolder.mainText.setText(items[position]);
                viewHolder.subText.setText("Size: " + items[position].length());

                return convertView;
            }
        };
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Item was clicked: " + items[i], Toast.LENGTH_SHORT).show();
            }
        });
        mListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

    }//On create

    public class ViewHolder{
        public ImageView avatar;
        public TextView mainText;
        public TextView subText;

    }

}
