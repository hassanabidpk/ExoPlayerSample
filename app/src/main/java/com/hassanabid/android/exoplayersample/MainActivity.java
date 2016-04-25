package com.hassanabid.android.exoplayersample;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.hassanabid.android.exoplayersample.player.PlayerActivity;
import com.hassanabid.android.exoplayersample.utils.Samples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Add Samples

        final List<SampleGroup> sampleGroups = new ArrayList<>();
        SampleGroup group = new SampleGroup("YouTube DASH");
        group.addAll(Samples.YOUTUBE_DASH_MP4);
        sampleGroups.add(group);
        group = new SampleGroup("Widevine DASH: MP4,H264");
        group.addAll(Samples.WIDEVINE_H264_MP4_CLEAR);
        group.addAll(Samples.WIDEVINE_H264_MP4_SECURE);
        sampleGroups.add(group);
        group = new SampleGroup("Widevine DASH: WebM,VP9");
        group.addAll(Samples.WIDEVINE_VP9_WEBM_CLEAR);
        sampleGroups.add(group);
        group = new SampleGroup("Widevine DASH: MP4,H265");
        group.addAll(Samples.WIDEVINE_H265_MP4_CLEAR);
        group.addAll(Samples.WIDEVINE_H265_MP4_SECURE);
        sampleGroups.add(group);
        group = new SampleGroup("HLS");
        group.addAll(Samples.HLS);
        sampleGroups.add(group);
        group = new SampleGroup("Misc");
        group.addAll(Samples.MISC);
        sampleGroups.add(group);
        ExpandableListView sampleList = (ExpandableListView) findViewById(R.id.sample_list);
        sampleList.setAdapter(new SampleAdapter(this, sampleGroups));
        sampleList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View view, int groupPosition,
                                        int childPosition, long id) {
                onSampleSelected(sampleGroups.get(groupPosition).samples.get(childPosition));
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void onSampleSelected(Samples.Sample sample) {
        Intent mpdIntent = new Intent(this, PlayerActivity.class)
                .setData(Uri.parse(sample.uri))
                .putExtra(PlayerActivity.CONTENT_ID_EXTRA, sample.contentId)
                .putExtra(PlayerActivity.CONTENT_TYPE_EXTRA, sample.type)
                .putExtra(PlayerActivity.PROVIDER_EXTRA, sample.provider);
        startActivity(mpdIntent);
    }

    private static final class SampleAdapter extends BaseExpandableListAdapter {

        private final Context context;
        private final List<SampleGroup> sampleGroups;

        public SampleAdapter(Context context, List<SampleGroup> sampleGroups) {
            this.context = context;
            this.sampleGroups = sampleGroups;
        }

        @Override
        public Samples.Sample getChild(int groupPosition, int childPosition) {
            return getGroup(groupPosition).samples.get(childPosition);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                                 View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent,
                        false);
            }
            ((TextView) view).setText(getChild(groupPosition, childPosition).name);
            return view;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return getGroup(groupPosition).samples.size();
        }

        @Override
        public SampleGroup getGroup(int groupPosition) {
            return sampleGroups.get(groupPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                                 ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.sample_chooser_inline_header, parent,
                        false);
            }
            ((TextView) view).setText(getGroup(groupPosition).title);
            return view;
        }

        @Override
        public int getGroupCount() {
            return sampleGroups.size();
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

    }

    private static final class SampleGroup {

        public final String title;
        public final List<Samples.Sample> samples;


        public SampleGroup(String title) {
            this.title = title;
            this.samples = new ArrayList<>();
        }

        public void addAll(Samples.Sample[] samples) {
            Collections.addAll(this.samples, samples);
        }

    }
}
