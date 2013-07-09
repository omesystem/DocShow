package com.example.docshow;

import android.app.Activity; 
import android.content.Context; 
import android.content.Intent;
import android.os.Bundle; 
import android.view.View; 
import android.view.ViewGroup; 
import android.widget.AdapterView; 
import android.widget.AdapterView.OnItemClickListener; 
import android.widget.BaseAdapter; 
import android.widget.GridView; 
import android.widget.ImageView; 
import android.widget.Toast; 


public class MainActivity extends Activity { 
	
	private static final String INTENT_GUIDE = "android.intent.action.GuideDetail";
	private static final String INTENT_ID = "id";
	
    @Override
    public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main); 
        GridView gv = (GridView)findViewById(R.id.gridView1); 
        //ΪGridView���������� 
        gv.setAdapter(new MyAdapter(this)); 
        //ע������¼� 
        gv.setOnItemClickListener(new OnItemClickListener() 
        { 
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
            { 
                Intent intent = new Intent(INTENT_GUIDE);
                intent.putExtra(INTENT_ID, position);
                startActivity(intent);
            } 
        }); 
    } 
} 
    //�Զ��������� 
    class MyAdapter extends BaseAdapter{ 
        //�����Ķ��� 
        private Context context; 
        //ͼƬ���� 
        private Integer[] imgs = { 
                R.drawable.jpg0, R.drawable.jpg1, R.drawable.jpg2,  
                R.drawable.jpg3, R.drawable.jpg4, R.drawable.jpg5,                
                R.drawable.jpg6, R.drawable.jpg7, R.drawable.jpg8,  
                R.drawable.jpg10, R.drawable.jpg11, R.drawable.jpg9,  
                R.drawable.jpg3, R.drawable.jpg4, R.drawable.jpg5,                
                R.drawable.jpg6, R.drawable.jpg7, R.drawable.jpg8, 
                R.drawable.jpg6, R.drawable.jpg7, R.drawable.jpg8,  
                R.drawable.jpg10, R.drawable.jpg11, R.drawable.jpg9, 
        }; 
        MyAdapter(Context context){ 
            this.context = context; 
        } 
        public int getCount() { 
            return imgs.length; 
        } 
 
        public Object getItem(int item) { 
            return item; 
        } 
 
        public long getItemId(int id) { 
            return id; 
        } 
         
        //����View���� 
        public View getView(int position, View convertView, ViewGroup parent) { 
             ImageView imageView; 
                if (convertView == null) { 
                    imageView = new ImageView(context); 
                    imageView.setLayoutParams(new GridView.LayoutParams(150, 150));//����ImageView���󲼾� 
                    imageView.setAdjustViewBounds(false);//���ñ߽���� 
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);//���ÿ̶ȵ����� 
                    imageView.setPadding(8, 8, 8, 8);//���ü�� 
                }  
                else { 
                    imageView = (ImageView) convertView; 
                } 
                imageView.setImageResource(imgs[position]);//ΪImageView����ͼƬ��Դ 
                return imageView; 
        } 
} 
   