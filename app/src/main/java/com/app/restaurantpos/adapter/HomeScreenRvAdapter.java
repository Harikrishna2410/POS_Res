package com.app.restaurantpos.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.app.restaurantpos.Constant;
import com.app.restaurantpos.R;
import com.app.restaurantpos.customers.CustomersActivity;
import com.app.restaurantpos.expense.ExpenseActivity;
import com.app.restaurantpos.model.HomeScreenRvModel;
import com.app.restaurantpos.orders.OrdersActivity;
import com.app.restaurantpos.pos.PosActivity;
import com.app.restaurantpos.product.ProductActivity;
import com.app.restaurantpos.report.ReportActivity;
import com.app.restaurantpos.settings.SettingsActivity;
import com.app.restaurantpos.suppliers.SuppliersActivity;

import java.util.List;

import es.dmoral.toasty.Toasty;

public class HomeScreenRvAdapter extends RecyclerView.Adapter<HomeScreenRvAdapter.ViewHolder> {

  Context context;
  List<HomeScreenRvModel> list;
  String userType;

  public HomeScreenRvAdapter(Context context, List<HomeScreenRvModel> list, String userType) {
    this.context = context;
    this.list = list;
    this.userType = userType;
  }

  @Override
  public HomeScreenRvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater
        = LayoutInflater.from(context);

    // Inflate the layout

    View view = inflater.inflate(R.layout.homescreen_rv_layout, parent, false);

    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(HomeScreenRvAdapter.ViewHolder holder, int position) {
    HomeScreenRvModel model = list.get(position);
    holder.txttitle.setText(model.txt);
    holder.imageView.setImageResource(model.image);
    holder.item_btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        int position = holder.getAdapterPosition();
        switch (position) {
          case 0:
            context.startActivity(new Intent(context, CustomersActivity.class));
            Toast.makeText(context, holder.txttitle.getText().toString(), Toast.LENGTH_SHORT).show();
            break;

          case 1:
            context.startActivity(new Intent(context, SuppliersActivity.class));
            break;

          case 2:
            context.startActivity(new Intent(context, ProductActivity.class));
            break;

          case 3:
            context.startActivity(new Intent(context, PosActivity.class));
            break;

          case 4:
            if (userType.equals("admin") || userType.equals("manager")) {
              context.startActivity(new Intent(context, ExpenseActivity.class));
            } else {
              Toasty.error(context, R.string.you_dont_have_permission_to_access_this_page, Toast.LENGTH_SHORT).show();
            }
            break;

          case 5:
            context.startActivity(new Intent(context, OrdersActivity.class));
            break;

          case 6:
            if (userType.equals(Constant.ADMIN) || userType.equals(Constant.MANAGER)) {
              context.startActivity(new Intent(context, ReportActivity.class));
            } else {
              Toasty.error(context, R.string.you_dont_have_permission_to_access_this_page, Toast.LENGTH_SHORT).show();
            }
            break;

          case 7:
            if (userType.equals("admin")) {
              context.startActivity(new Intent(context, SettingsActivity.class));
            } else {
              Toasty.error(context, R.string.you_dont_have_permission_to_access_this_page, Toast.LENGTH_SHORT).show();
            }
            break;

        }
      }
    });

  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    TextView txttitle;
    ImageView imageView;
    ConstraintLayout item_btn;

    public ViewHolder(View itemView) {
      super(itemView);
      txttitle = itemView.findViewById(R.id.homescreen_rv_layout_txt);
      imageView = itemView.findViewById(R.id.homescreen_rv_layout_img);
      item_btn = itemView.findViewById(R.id.homescreen_rv_layout_cv);

    }
  }

  @SuppressLint("ResourceAsColor")
  public void changeOnClick(TextView txttitle, CardView cv) {

    txttitle.setTextColor(R.color.white);
    cv.setCardBackgroundColor(R.color.colorPrimary);

  }

}
