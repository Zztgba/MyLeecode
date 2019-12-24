package com.test.inteface;

/**
 * @Author zhongzaitao
 * @Date 2019-9-11 20:58
 */
public class Button {

    public interface OnClickListener{
        void click();
    }

    public interface OnLongClickListener{
        void longClick();
    }

    private OnClickListener onClickListener;

    private OnLongClickListener onLongClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void mockClick(){
        if (onClickListener!=null){
            onClickListener.click();
        }
    }

    public void mockLongClick(){
        if (onLongClickListener!=null){
            onLongClickListener.longClick();
        }
    }
}
