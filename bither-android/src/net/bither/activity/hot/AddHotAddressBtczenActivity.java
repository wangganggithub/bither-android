/*
 * Copyright 2014 http://Bither.net
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.bither.activity.hot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import net.bither.BitherSetting;
import net.bither.R;
import net.bither.bitherj.core.AddressManager;
import net.bither.bitherj.crypto.PasswordSeed;
import net.bither.fragment.hot.AddAddressHotHDAccountFragment;
import net.bither.fragment.hot.AddAddressHotHDAccountViewFragment;
import net.bither.fragment.hot.AddAddressHotOtherFragment;
import net.bither.fragment.hot.AddAddressPrivateKeyFragment;
import net.bither.ui.base.AddPrivateKeyActivity;
import net.bither.util.StringUtil;

import java.util.ArrayList;

public class AddHotAddressBtczenActivity extends AddPrivateKeyActivity {

    private boolean shouldSuggestCheck = false;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_add_hot_address);
        if (!PasswordSeed.hasPasswordSeed()) {
            shouldSuggestCheck = true;
        } else {
            shouldSuggestCheck = false;
        }
        initView();
    }

    private void initView() {

        Button btn_add_btczen = (Button) findViewById(R.id.btn_add_btczen);
        btn_add_btczen.setOnClickListener(new IndicatorClick());
    }

    public void save() {
        /*
        Fragment f = getActiveFragment();
        if (f != null && f instanceof AddAddress) {
            AddAddress a = (AddAddress) f;
            ArrayList<String> addresses = a.getAddresses();
            Intent intent = new Intent();
            intent.putExtra(BitherSetting.INTENT_REF.ADDRESS_POSITION_PASS_VALUE_TAG, addresses);
            if (f instanceof AddAddressPrivateKeyFragment) {
                intent.putExtra(BitherSetting.INTENT_REF.ADD_PRIVATE_KEY_SUGGEST_CHECK_TAG,
                        shouldSuggestCheck);
            }
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
        */
    }

    private class IndicatorClick implements OnClickListener {

        @Override
        public void onClick(View v) {
            save();
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.slide_out_bottom);
    }

    public static interface AddAddress {
        public ArrayList<String> getAddresses();
    }
}
