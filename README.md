# CoronoTracker-MVVM-LiveData

LiveData is introduced as lifecycle-aware data holder with the observer pattern. That means, When something is new in data set it will notify. It automatically changes the view for the changes in the data set. In this tutorial, we will demonstrate LiveData android example

When we have LiveData object(eg. list of customers, can be a list of users, it can be any data sources ), we add some Lifecycle Owner (such as Activity or Fragment) as an observer to this data update. Same as observer pattern but with respecting lifecycle states.

In large application there can be two type of data source. Local Sqlite database, remote Rest APIs . With Live we can write code for observer these data source for data changes and update views accordingly.

# Benefits of using LiveData
Ensures your UI matches your data state- It based on observer pattern. So we’ll be notified every time the data changes instead of requesting the data each time from ViewModel.

Avoid memory leaks – Observers bounded with life cycle and when lifecycle is destroyed LiveData object also destroy.

No more crashes due to stopped activities- If the observer’s lifecycle is inactive, such as in the case of an activity in the back stack, then it doesn’t receive any LiveData events.

No more manual lifecycle handling – UI components just observe relevant data and don’t stop or resume observation. LiveData automatically manages all of this since it’s aware of the relevant lifecycle status changes while observing.

Always up to date data – If a lifecycle becomes inactive, it receives the latest data upon becoming active again. For example, an activity that was in the background receives the latest data right after it returns to the foreground.

Manage all configuration changes –If an activity or fragment is recreated due to a configuration change, like device rotation, it immediately receives the latest available data.

![image](https://user-images.githubusercontent.com/39657409/78127571-06d48800-7432-11ea-9049-59bc56980b74.png)

![image](https://user-images.githubusercontent.com/39657409/78127592-1227b380-7432-11ea-824a-a1e4f5da992d.png)
