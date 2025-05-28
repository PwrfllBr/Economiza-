import { Close, Refresh } from "@mui/icons-material";
import { AppBar, Box, FormControl, IconButton, InputLabel, MenuItem, Select, SelectChangeEvent, Toolbar } from "@mui/material";
import React from "react"
import MenuIcon from "@mui/icons-material/Menu";
import logo from "../../assets/react.svg";

interface MainToolBarProps {
    isDrawerOpen: boolean;
    toggleDrawer: () => void;
    selectedPeriod: string;
    handlePeriodChange: (event: SelectChangeEvent) => void;
    selectedWallet: string;
    handleWalletChange: (event: SelectChangeEvent) => void;
    onRefresh: () => void;
    onClose: () => void;
}
 
const MainToolBar: React.FunctionComponent<MainToolBarProps> = ({
    isDrawerOpen,
    toggleDrawer,
    selectedPeriod,
    handlePeriodChange,
    selectedWallet,
    handleWalletChange,
    //onRefresh,
    //onClose
}) => {
    return (
        <AppBar position="static" color="default">
        <Toolbar>
          {/* toggle drawer button */}
          <IconButton aria-label="menu" edge="start" color="inherit"
          onClick={toggleDrawer}>
            {isDrawerOpen ? <Close /> : <MenuIcon />}
          </IconButton>
          {/* Centered logo */}
          <Box sx={{ flexGrow: 1, display: 'flex', justifyContent: 'center' }}>
            <img src={logo} alt="logo" />
          </Box>
          {/* Selectors and Refresh button */}
          <Box sx={{ alignItems: 'center', display: 'flex', flexDirection: 'row'}}>
            {/* Add your selectors here */}
            <Box sx={{ marginRight: 2, gap: 1, display: 'flex', flexDirection: 'row'}}>
              <FormControl sx={{ minWidth: 120 }}>
                <InputLabel>Period</InputLabel>
                <Select labelId='periods-select-label' id='periods-select' label='Periods'
                value={selectedPeriod} onChange={handlePeriodChange}>
                  <MenuItem value={"Week"}>Week</MenuItem>
                  <MenuItem value={"Month"}>Month</MenuItem>
                  <MenuItem value={"Year"}>Year</MenuItem>
                </Select>
              </FormControl>
              <FormControl sx={{ minWidth: 120 }}>
                <InputLabel>Wallet</InputLabel>
                <Select labelId='wallets-select-label' id='wallets-select' label='Wallets'
                value={selectedWallet} onChange={handleWalletChange}>
                  <MenuItem value="all">All Wallets</MenuItem>
                  <MenuItem value="wallet1">Wallet 1</MenuItem>
                  <MenuItem value="wallet2">Wallet 2</MenuItem>
                </Select>
              </FormControl>
            </Box>
              <IconButton color="inherit" onClick={() => console.log('Refresh clicked')}>
                <Refresh />
              </IconButton>
          </Box>
        </Toolbar>
        
      </AppBar>
    );
}
 
export default MainToolBar;