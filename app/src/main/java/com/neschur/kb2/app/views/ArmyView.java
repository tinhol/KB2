package com.neschur.kb2.app.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.view.MotionEvent;

import com.neschur.kb2.app.I18n;
import com.neschur.kb2.app.models.Player;
import com.neschur.kb2.app.views.interfaces.ViewClosable;
import com.neschur.kb2.app.warriors.WarriorSquad;

public class ArmyView extends View {
    private Player player;

    public ArmyView(Context context, Player player, ViewClosable closeCallback) {
        super(context, closeCallback);
        this.player = player;
    }

    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        closeCallback.viewClose();
        drawThread.refresh();
        return super.onTouchEvent(event);
    }

    public void draw(@NonNull Canvas canvas) {
        Paint paint = getDefaultPaint();
        canvas.drawColor(Color.BLACK);

        int imageWidth = stepX();
        int imageHeight = stepY();
        for (int i = 0; i < 5; i++) {
            WarriorSquad squad = player.getWarriorSquad(i);
            if (squad == null)
                continue;
            Bitmap image = Bitmap.createScaledBitmap(
                    BitmapFactory.decodeResource(
                            getContext().getResources(), squad.getWarrior().getId()
                    ),
                    imageWidth, imageHeight, false
            );

            canvas.drawBitmap(image, 0, imageHeight * i, null);
            canvas.drawText(I18n.translate("army_names_" + squad.getWarrior().getTextId()),
                    imageWidth + 10, menuItemHeight() + imageHeight * i, paint);
            canvas.drawText(Integer.toString(squad.getCount()),
                    imageWidth * 2 + 10, menuItemHeight() + imageHeight * i, paint);
        }

    }
}
