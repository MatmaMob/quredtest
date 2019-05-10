package com.example.qured_test.main;

import com.example.qured_test.data.PlaceHolderModel;

import java.util.List;

public interface MainContract {
    interface View{

        /**
         * Initialize main views
         */

        void initViews();

        /**
         * Set Recycler view with loaded network data
         * @param list list of network elements
         */

        void setRecyclerView(List<PlaceHolderModel> list);

        /**
         * Hide loading bar
         */

        void hideLoadingBar();

        /**
         * Show error message
         * @param message error message
         */
        void showErrorMessage(String message);
    }

    interface Presenter{

        /**
         * Start presenting screen
         */
        void startPresenting();

        /**
         * Present data to user when it is ready
         */

        void presentListWithData();
    }

    interface Gateway{

        /**
         * Load data from network
         * @param callback callback
         */

        void loadData(Callback callback);

        interface Callback{

            /**
             * Return list on network call success
             * @param list list of data
             */
            void onSuccess(List<PlaceHolderModel> list);

            /**
             * Return error information
             * @param t error information
             */
            void onFailure(Throwable t);
        }
    }
}
