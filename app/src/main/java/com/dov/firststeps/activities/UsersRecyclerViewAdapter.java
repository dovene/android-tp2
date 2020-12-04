package com.dov.firststeps.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.dov.firststeps.R;
import com.dov.firststeps.model.User;
import com.dov.firststeps.repository.UserRepository;

import java.util.ArrayList;

public class UsersRecyclerViewAdapter extends RecyclerView.Adapter<UsersRecyclerViewAdapter.UserViewHolder> {


    private ArrayList<User> users;

    public UsersRecyclerViewAdapter(ArrayList<User> users) {
        this.users = users;
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
        holder.bind(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView loginTV;
        AppCompatTextView nameTV;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            loginTV = itemView.findViewById(R.id.login_TV);
            nameTV = itemView.findViewById(R.id.name_TV);
        }

        public void bind(User user) {
            loginTV.setText(user.getLogin());
            nameTV.setText(user.getName());
        }
    }
}
