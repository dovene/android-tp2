package com.dov.firststeps.activities;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.dov.firststeps.R;
import com.dov.firststeps.model.User;
import com.dov.firststeps.repository.UserRepository;

import java.util.ArrayList;

public class UsersRecyclerViewAdapter extends RecyclerView.Adapter<UsersRecyclerViewAdapter.UserViewHolder> {

    public interface OnDeleteButtonClicked {
        void delete(User user);
    }

    private ArrayList<User> users;
    private OnDeleteButtonClicked onDeleteButtonClicked;

    public UsersRecyclerViewAdapter(ArrayList<User> users, OnDeleteButtonClicked onDeleteButtonClicked) {
        this.users = users;
        this.onDeleteButtonClicked = onDeleteButtonClicked;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bind(users.get(position), onDeleteButtonClicked);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView loginTV;
        AppCompatTextView nameTV;
        AppCompatButton deleteBT;
        ConstraintLayout holder;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            loginTV = itemView.findViewById(R.id.login_TV);
            nameTV = itemView.findViewById(R.id.name_TV);
            deleteBT = itemView.findViewById(R.id.delete_BT);
            holder = itemView.findViewById(R.id.holder);
        }

        public void bind(User user, OnDeleteButtonClicked onDeleteButtonClicked) {
            loginTV.setText(user.getLogin());
            nameTV.setText(user.getName());
            holder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(loginTV.getContext(), ProfileActivity.class);
                    intent.putExtra(ProfileActivity.USER_KEY, user);
                    loginTV.getContext().startActivity(intent);
                }
            });
            deleteBT.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onDeleteButtonClicked.delete(user);
                }
            });
        }
    }
}
