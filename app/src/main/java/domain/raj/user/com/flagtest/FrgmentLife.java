package domain.raj.user.com.flagtest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FrgmentLife extends Fragment {
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        System.out.println("Fragment onAttach");

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Fragment onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println("Fragment onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        System.out.println("Fragment onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("Fragment onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("Fragment onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("Fragment onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("Fragment onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("Fragment onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("Fragment onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Fragment onDestroy");
    }



    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("Fragment onDetach");
    }
}
