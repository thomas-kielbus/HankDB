package com.rapleaf.hank.coordinator;

import java.io.IOException;
import java.util.Set;

import com.rapleaf.hank.BaseTestCase;

public class TestAbstractRingConfig extends BaseTestCase {
  private static class SlightlyLessAbstractRingConfig extends AbstractRingConfig {
    protected SlightlyLessAbstractRingConfig(int ringNum,
        RingGroupConfig ringGroupConfig) {
      super(ringNum, ringGroupConfig);
    }

    @Override
    public HostConfig addHost(PartDaemonAddress address) throws IOException {
      return null;
    }

    @Override
    public HostConfig getHostConfigByAddress(PartDaemonAddress address) {
      return null;
    }

    @Override
    public Set<HostConfig> getHosts() {
      return null;
    }

    @Override
    public RingState getState() throws IOException {
      return null;
    }

    @Override
    public Integer getUpdatingToVersionNumber() {
      return null;
    }

    @Override
    public Integer getVersionNumber() {
      return null;
    }

    @Override
    public void setState(RingState newState) throws IOException {
    }

    @Override
    public void setStateChangeListener(RingStateChangeListener listener) throws IOException {
    }

    @Override
    public void setUpdatingToVersion(int latestVersionNumber) throws IOException {
    }

    @Override
    public void updateComplete() throws IOException {
    }
  }

  public void testIsUpdatePending() {
    assertTrue(new SlightlyLessAbstractRingConfig(1, null) {
      @Override
      public Integer getUpdatingToVersionNumber() {
        return 5;
      }
    }.isUpdatePending());

    assertFalse(new SlightlyLessAbstractRingConfig(1, null) {
      @Override
      public Integer getUpdatingToVersionNumber() {
        return null;
      }
    }.isUpdatePending());
  }
}
